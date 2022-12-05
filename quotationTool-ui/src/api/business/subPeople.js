import request from '@/utils/request'

// 查询场馆预约人数列表
export function listSubPeople(query) {
  return request({
    url: '/business/subPeople/list',
    method: 'get',
    params: query
  })
}

// 查询场馆预约人数详细
export function getSubPeople(id) {
  return request({
    url: '/business/subPeople/' + id,
    method: 'get'
  })
}

// 新增场馆预约人数
export function addSubPeople(data) {
  return request({
    url: '/business/subPeople',
    method: 'post',
    data: data
  })
}

// 修改场馆预约人数
export function updateSubPeople(data) {
  return request({
    url: '/business/subPeople',
    method: 'put',
    data: data
  })
}

// 删除场馆预约人数
export function delSubPeople(id) {
  return request({
    url: '/business/subPeople/' + id,
    method: 'delete'
  })
}
