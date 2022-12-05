import request from '@/utils/request'

// 查询文化资讯配置列表
export function listCulture(query) {
  return request({
    url: '/screenSet/culture/list',
    method: 'get',
    params: query
  })
}

// 查询文化资讯配置详细
export function getCulture(id) {
  return request({
    url: '/screenSet/culture/' + id,
    method: 'get'
  })
}

// 新增文化资讯配置
export function addCulture(data) {
  return request({
    url: '/screenSet/culture',
    method: 'post',
    data: data
  })
}

// 修改文化资讯配置
export function updateCulture(data) {
  return request({
    url: '/screenSet/culture',
    method: 'put',
    data: data
  })
}

// 删除文化资讯配置
export function delCulture(id) {
  return request({
    url: '/screenSet/culture/' + id,
    method: 'delete'
  })
}
