import request from '@/utils/request'

// 查询sensitiv列表
export function listSensitiv(query) {
  return request({
    url: '/business/sensitiv/list',
    method: 'get',
    params: query
  })
}

// 查询sensitiv详细
export function getSensitiv(sensitiveId) {
  return request({
    url: '/business/sensitiv/' + sensitiveId,
    method: 'get'
  })
}

// 新增sensitiv
export function addSensitiv(data) {
  return request({
    url: '/business/sensitiv',
    method: 'post',
    data: data
  })
}

// 修改sensitiv
export function updateSensitiv(data) {
  return request({
    url: '/business/sensitiv',
    method: 'put',
    data: data
  })
}

// 删除sensitiv
export function delSensitiv(sensitiveId) {
  return request({
    url: '/business/sensitiv/' + sensitiveId,
    method: 'delete'
  })
}
