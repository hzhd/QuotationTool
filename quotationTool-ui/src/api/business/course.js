import request from '@/utils/request'

// 查询慕课库数据维护列表
export function listCourse(query) {
  return request({
    url: '/business/course/list',
    method: 'get',
    params: query
  })
}

// 查询慕课库数据维护详细
export function getCourse(id) {
  return request({
    url: '/business/course/' + id,
    method: 'get'
  })
}

// 新增慕课库数据维护
export function addCourse(data) {
  return request({
    url: '/business/course',
    method: 'post',
    data: data
  })
}

// 修改慕课库数据维护
export function updateCourse(data) {
  return request({
    url: '/business/course',
    method: 'put',
    data: data
  })
}

// 删除慕课库数据维护
export function delCourse(id) {
  return request({
    url: '/business/course/' + id,
    method: 'delete'
  })
}
