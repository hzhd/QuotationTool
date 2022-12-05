import request from '@/utils/request'

// 查询教室管理列表
export function listClassroom(query) {
  return request({
    url: '/business/classroom/list',
    method: 'get',
    params: query
  })
}

// 查询教室管理详细
export function getClassroom(classroomId) {
  return request({
    url: '/business/classroom/' + classroomId,
    method: 'get'
  })
}

// 新增教室管理
export function addClassroom(data) {
  return request({
    url: '/business/classroom',
    method: 'post',
    data: data
  })
}

// 修改教室管理
export function updateClassroom(data) {
  return request({
    url: '/business/classroom',
    method: 'put',
    data: data
  })
}

// 删除教室管理
export function delClassroom(classroomId) {
  return request({
    url: '/business/classroom/' + classroomId,
    method: 'delete'
  })
}

// 查询场馆信息
export function queryStadium() {
    return request({
        url: '/business/stadiumInfo/queryStadiumList',
        method: 'get'
    })
}
