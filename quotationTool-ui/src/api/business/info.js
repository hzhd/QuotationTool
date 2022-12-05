import request from '@/utils/request'

// 查询影响力统计列表
export function listInfo(query) {
  return request({
    url: '/business/info/list',
    method: 'get',
    params: query
  })
}

// 查询影响力统计详细
export function getInfo(id) {
  return request({
    url: '/business/info/' + id,
    method: 'get'
  })
}

// 新增影响力统计
export function addInfo(data) {
  return request({
    url: '/business/info',
    method: 'post',
    data: data
  })
}

// 修改影响力统计
export function updateInfo(data) {
  return request({
    url: '/business/info',
    method: 'put',
    data: data
  })
}

// 删除影响力统计
export function delInfo(id) {
  return request({
    url: '/business/info/' + id,
    method: 'delete'
  })
}
