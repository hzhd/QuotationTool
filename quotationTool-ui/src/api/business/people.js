import request from '@/utils/request'

// 查询进出人数统计列表
export function listPeople(query) {
  return request({
    url: '/business/people/list',
    method: 'get',
    params: query
  })
}

// 查询进出人数统计详细
export function getPeople(id) {
  return request({
    url: '/business/people/' + id,
    method: 'get'
  })
}

// 新增进出人数统计
export function addPeople(data) {
  return request({
    url: '/business/people',
    method: 'post',
    data: data
  })
}

// 修改进出人数统计
export function updatePeople(data) {
  return request({
    url: '/business/people',
    method: 'put',
    data: data
  })
}

// 删除进出人数统计
export function delPeople(id) {
  return request({
    url: '/business/people/' + id,
    method: 'delete'
  })
}
