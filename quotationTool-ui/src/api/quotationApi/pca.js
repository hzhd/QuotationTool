import {pcaData} from "@/api/quotationData/pca.data.js";
import request from '@/utils/request'

export function getProvince(){
  return pcaData.map((i) => {
    const { code, name } = i;
    return { code, name };
  });
};

export function getCityByProvince(p){
  const province = pcaData().filter((data) => data.code == p);
  if (province.length) {
    return province[0].children.map((i) => {
      const { code, name, children } = i;
      return { code, name, children };
    });
  }
  return [];
};

export function getCountryByCity(p, pList) {
  const city = pList.filter((data) => data.code == p);
  if (city.length) {
    return city[0].children.map((i) => {
      const { code, name, children } = i;
      return { code, name, children };
    });
  }
  return [];
};
