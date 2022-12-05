import request from '@/utils/request'

// 查询档案分类列表
export function listClassify(query) {
  return request({
    url: '/business/classify/list',
    method: 'get',
    params: query
  })
}

// 查询档案分类详细
export function getClassify(recordId) {
  return request({
    url: '/business/classify/' + recordId,
    method: 'get'
  })
}

// 新增档案分类
export function addClassify(data) {
  return request({
    url: '/business/classify',
    method: 'post',
    data: data
  })
}

// 修改档案分类
export function updateClassify(data) {
  return request({
    url: '/business/classify',
    method: 'put',
    data: data
  })
}

// 删除档案分类
export function delClassify(recordId) {
  return request({
    url: '/business/classify/' + recordId,
    method: 'delete'
  })
}
