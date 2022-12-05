import request from '@/utils/request'

// 查询客流统计列表
export function listPassenger(query) {
  return request({
    url: '/business/passenger/list',
    method: 'get',
    params: query
  })
}

// 查询客流统计详细
export function getPassenger(id) {
  return request({
    url: '/business/passenger/' + id,
    method: 'get'
  })
}

// 新增客流统计
export function addPassenger(data) {
  return request({
    url: '/business/passenger',
    method: 'post',
    data: data
  })
}

// 修改客流统计
export function updatePassenger(data) {
  return request({
    url: '/business/passenger',
    method: 'put',
    data: data
  })
}

// 删除客流统计
export function delPassenger(id) {
  return request({
    url: '/business/passenger/' + id,
    method: 'delete'
  })
}
