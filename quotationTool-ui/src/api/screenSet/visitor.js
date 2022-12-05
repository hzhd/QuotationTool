import request from '@/utils/request'

// 查询游客大屏配置列表
export function listVisitor(query) {
  return request({
    url: '/screenSet/visitor/list',
    method: 'get',
    params: query
  })
}

// 查询游客大屏配置详细
export function getVisitor(id) {
  return request({
    url: '/screenSet/visitor/' + id,
    method: 'get'
  })
}

// 新增游客大屏配置
export function addVisitor(data) {
  return request({
    url: '/screenSet/visitor',
    method: 'post',
    data: data
  })
}

// 修改游客大屏配置
export function updateVisitor(data) {
  return request({
    url: '/screenSet/visitor',
    method: 'put',
    data: data
  })
}

// 删除游客大屏配置
export function delVisitor(id) {
  return request({
    url: '/screenSet/visitor/' + id,
    method: 'delete'
  })
}
