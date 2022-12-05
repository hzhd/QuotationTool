import request from '@/utils/request'

// 查询文化咨询库列表
export function listCultrue(query) {
  return request({
    url: '/business/cultrue/list',
    method: 'get',
    params: query
  })
}

// 查询文化咨询库详细
export function getCultrue(id) {
  return request({
    url: '/business/cultrue/' + id,
    method: 'get'
  })
}

// 新增文化咨询库
export function addCultrue(data) {
  return request({
    url: '/business/cultrue',
    method: 'post',
    data: data
  })
}

// 修改文化咨询库
export function updateCultrue(data) {
  return request({
    url: '/business/cultrue',
    method: 'put',
    data: data
  })
}

// 删除文化咨询库
export function delCultrue(id) {
  return request({
    url: '/business/cultrue/' + id,
    method: 'delete'
  })
}
