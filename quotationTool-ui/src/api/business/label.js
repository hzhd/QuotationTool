import request from '@/utils/request'

// 查询标签库列表
export function listLabel(query) {
  return request({
    url: '/business/label/list',
    method: 'get',
    params: query
  })
}

// 查询标签库详细
export function getLabel(labelId) {
  return request({
    url: '/business/label/' + labelId,
    method: 'get'
  })
}

// 新增标签库
export function addLabel(data) {
  return request({
    url: '/business/label',
    method: 'post',
    data: data
  })
}

// 修改标签库
export function updateLabel(data) {
  return request({
    url: '/business/label',
    method: 'put',
    data: data
  })
}

// 删除标签库
export function delLabel(labelId) {
  return request({
    url: '/business/label/' + labelId,
    method: 'delete'
  })
}
