package com.ruoyi.framework.sso;

import com.auth0.jwk.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.*;

public class PtarUrlJwkProvider implements JwkProvider {
    static final String WELL_KNOWN_JWKS_PATH = "/.well-known/jwks.json";
    final URL url;
    final Proxy proxy;
    final Map<String, String> headers;
    final Integer connectTimeout;
    final Integer readTimeout;
    private final ObjectReader reader;

    public PtarUrlJwkProvider(URL url) {
        this(url, (Integer)null, (Integer)null, (Proxy)null, (Map)null);
    }

    public PtarUrlJwkProvider(URL url, Integer connectTimeout, Integer readTimeout, Proxy proxy) {
        this(url, connectTimeout, readTimeout, proxy, (Map)null);
    }

    public PtarUrlJwkProvider(URL url, Integer connectTimeout, Integer readTimeout, Proxy proxy, Map<String, String> headers) {
        CommonUtil.checkArgument(url != null, "A non-null url is required");
        CommonUtil.checkArgument(connectTimeout == null || connectTimeout >= 0, "Invalid connect timeout value '" + connectTimeout + "'. Must be a non-negative integer.");
        CommonUtil.checkArgument(readTimeout == null || readTimeout >= 0, "Invalid read timeout value '" + readTimeout + "'. Must be a non-negative integer.");
        this.url = url;
        this.proxy = proxy;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.reader = (new ObjectMapper()).readerFor(Map.class);
        this.headers = headers == null ? Collections.singletonMap("Accept", "application/json") : headers;
    }

    public PtarUrlJwkProvider(URL url, Integer connectTimeout, Integer readTimeout) {
        this(url, connectTimeout, readTimeout, (Proxy)null, (Map)null);
    }

    public PtarUrlJwkProvider(String domain) {
        this(urlForDomain(domain));
    }

    static URL urlForDomain(String domain) {
        CommonUtil.checkArgument(!CommonUtil.isNullOrEmpty(domain), "A domain is required");
        if (!domain.startsWith("http")) {
            domain = "https://" + domain;
        }

        try {
            URI uri = (new URI(domain)).normalize();
            return uri.toURL();
        } catch (URISyntaxException | MalformedURLException var2) {
            throw new IllegalArgumentException("Invalid jwks uri", var2);
        }
    }

    private Map<String, Object> getJwks() throws SigningKeyNotFoundException {
        try {
            URLConnection c = this.proxy == null ? this.url.openConnection() : this.url.openConnection(this.proxy);
            if (this.connectTimeout != null) {
                c.setConnectTimeout(this.connectTimeout);
            }

            if (this.readTimeout != null) {
                c.setReadTimeout(this.readTimeout);
            }

            Iterator var2 = this.headers.entrySet().iterator();

            while(var2.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry)var2.next();
                c.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
            }

            InputStream inputStream = c.getInputStream();
            Throwable var18 = null;

            Map var4;
            try {
                var4 = (Map)this.reader.readValue(inputStream);
            } catch (Throwable var14) {
                var18 = var14;
                throw var14;
            } finally {
                if (inputStream != null) {
                    if (var18 != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable var13) {
                            var18.addSuppressed(var13);
                        }
                    } else {
                        inputStream.close();
                    }
                }

            }

            return var4;
        } catch (IOException var16) {
            throw new NetworkException("Cannot obtain jwks from url " + this.url.toString(), var16);
        }
    }

    public List<Jwk> getAll() throws SigningKeyNotFoundException {
        List<Jwk> jwks = new ArrayList();
        List<Map<String, Object>> keys = (List)this.getJwks().get("keys");
        if (keys != null && !keys.isEmpty()) {
            try {
                Iterator var3 = keys.iterator();

                while(var3.hasNext()) {
                    Map<String, Object> values = (Map)var3.next();
                    jwks.add(Jwk.fromValues(values));
                }

                return jwks;
            } catch (IllegalArgumentException var5) {
                throw new SigningKeyNotFoundException("Failed to parse jwk from json", var5);
            }
        } else {
            throw new SigningKeyNotFoundException("No keys found in " + this.url.toString(), (Throwable)null);
        }
    }

    public Jwk get(String keyId) throws JwkException {
        List<Jwk> jwks = this.getAll();
        if (keyId == null && jwks.size() == 1) {
            return (Jwk)jwks.get(0);
        } else {
            if (keyId != null) {
                Iterator var3 = jwks.iterator();

                while(var3.hasNext()) {
                    Jwk jwk = (Jwk)var3.next();
                    if (keyId.equals(jwk.getId())) {
                        return jwk;
                    }
                }
            }

            throw new SigningKeyNotFoundException("No key found in " + this.url.toString() + " with kid " + keyId, (Throwable)null);
        }
    }
}
