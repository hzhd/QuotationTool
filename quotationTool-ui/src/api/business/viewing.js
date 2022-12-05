import request from '@/utils/request'

// 查询电影统计列表
export function listViewing(query) {
  return request({
    url: '/business/viewing/list',
    method: 'get',
    params: query
  })
}

// 查询电影统计详细
export function getViewing(id) {
  return request({
    url: '/business/viewing/' + id,
    method: 'get'
  })
}

// 新增电影统计
export function addViewing(data) {
  return request({
    url: '/business/viewing',
    method: 'post',
    data: data
  })
}

// 修改电影统计
export function updateViewing(data) {
  return request({
    url: '/business/viewing',
    method: 'put',
    data: data
  })
}

// 删除电影统计
export function delViewing(id) {
  return request({
    url: '/business/viewing/' + id,
    method: 'delete'
  })
}
