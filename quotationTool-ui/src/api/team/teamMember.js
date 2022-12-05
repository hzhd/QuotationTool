import request from '@/utils/request'

// 查询团队成员列表
export function listTeamMember(query) {
  return request({
    url: '/team/teamMember/list',
    method: 'get',
    params: query
  })
}

// 查询团队成员详细
export function getTeamMember(id) {
  return request({
    url: '/team/teamMember/' + id,
    method: 'get'
  })
}

// 新增团队成员
export function addTeamMember(data) {
  return request({
    url: '/team/teamMember',
    method: 'post',
    data: data
  })
}

// 修改团队成员
export function updateTeamMember(data) {
  return request({
    url: '/team/teamMember',
    method: 'put',
    data: data
  })
}

// 删除团队成员
export function delTeamMember(id) {
  return request({
    url: '/team/teamMember/' + id,
    method: 'delete'
  })
}
