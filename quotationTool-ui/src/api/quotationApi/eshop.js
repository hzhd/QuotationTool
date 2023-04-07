import request from '@/utils/request'

// 查询推送数据列表
export function listEshop(query) {
  return request({
    url: '/eshop/eshop/list',
    method: 'get',
    params: query
  })
}

// 查询推送数据详细
export function getEshop(id) {
  return request({
    url: '/eshop/eshop/' + id,
    method: 'get'
  })
}

// 新增推送数据---单独eshop推送使用
export function addEshop(data) {
  return request({
    url: '/eshop/eshop',
    method: 'post',
    data: data
  })
}

// 新增推送数据---报价流程使用
export function addEshopQuotation(data) {
  return request({
    url: '/eshop/eshop/addQuotation',
    method: 'post',
    data: data
  })
}

// 修改推送数据
export function updateEshop(data) {
  return request({
    url: '/eshop/eshop',
    method: 'put',
    data: data
  })
}

// 删除推送数据
export function delEshop(id) {
  return request({
    url: '/eshop/eshop/' + id,
    method: 'delete'
  })
}
