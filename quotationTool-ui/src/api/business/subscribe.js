import request from '@/utils/request'

// 查询预约统计列表
export function listSubscribe(query) {
  return request({
    url: '/business/subscribe/list',
    method: 'get',
    params: query
  })
}

// 查询预约统计详细
export function getSubscribe(id) {
  return request({
    url: '/business/subscribe/' + id,
    method: 'get'
  })
}

// 新增预约统计
export function addSubscribe(data) {
  return request({
    url: '/business/subscribe',
    method: 'post',
    data: data
  })
}

// 修改预约统计
export function updateSubscribe(data) {
  return request({
    url: '/business/subscribe',
    method: 'put',
    data: data
  })
}

// 删除预约统计
export function delSubscribe(id) {
  return request({
    url: '/business/subscribe/' + id,
    method: 'delete'
  })
}
