import request from '@/utils/request'

// 查询场馆信息列表
export function listStadiumInfo(query) {
  return request({
    url: '/business/stadiumInfo/list',
    method: 'get',
    params: query
  })
}

// 查询场馆信息详细
export function getStadiumInfo(stadiumId) {
  return request({
    url: '/business/stadiumInfo/' + stadiumId,
    method: 'get'
  })
}

// 新增场馆信息
export function addStadiumInfo(data) {
  return request({
    url: '/business/stadiumInfo',
    method: 'post',
    data: data
  })
}

// 修改场馆信息
export function updateStadiumInfo(data) {
  return request({
    url: '/business/stadiumInfo',
    method: 'put',
    data: data
  })
}

// 删除场馆信息
export function delStadiumInfo(stadiumId) {
  return request({
    url: '/business/stadiumInfo/' + stadiumId,
    method: 'delete'
  })
}
