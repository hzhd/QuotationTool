import request from '@/utils/request'

// 查询非遗库数据维护列表
export function listIchInfo(query) {
  return request({
    url: '/business/ichInfo/list',
    method: 'get',
    params: query
  })
}

// 查询非遗库数据维护详细
export function getIchInfo(ichId) {
  return request({
    url: '/business/ichInfo/' + ichId,
    method: 'get'
  })
}

// 新增非遗库数据维护
export function addIchInfo(data) {
  return request({
    url: '/business/ichInfo',
    method: 'post',
    data: data
  })
}

// 修改非遗库数据维护
export function updateIchInfo(data) {
  return request({
    url: '/business/ichInfo',
    method: 'put',
    data: data
  })
}

// 删除非遗库数据维护
export function delIchInfo(ichId) {
  return request({
    url: '/business/ichInfo/' + ichId,
    method: 'delete'
  })
}
