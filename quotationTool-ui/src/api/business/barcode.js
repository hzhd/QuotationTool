import request from '@/utils/request'

// 查询生成二维码列表
export function listBarcode(query) {
  return request({
    url: '/barcode/barcode/list',
    method: 'get',
    params: query
  })
}

// 查询生成二维码详细
export function getBarcode(id) {
  return request({
    url: '/barcode/barcode/' + id,
    method: 'get'
  })
}

// 新增生成二维码
export function addBarcode(data) {
  return request({
    url: '/barcode/barcode',
    method: 'post',
    data: data
  })
}

// 修改生成二维码
export function updateBarcode(data) {
  return request({
    url: '/barcode/barcode',
    method: 'put',
    data: data
  })
}

// 删除生成二维码
export function delBarcode(id) {
  return request({
    url: '/barcode/barcode/' + id,
    method: 'delete'
  })
}

// 销售人员视图数据
export function getSalesList() {
  return request({
    url: '/eshop/getSalesList',
    method: 'get',
  })
}

// 经销商视图数据
export function getDistributorList() {
  return request({
    url: '/eshop/getDistributorList',
    method: 'get',
  })
}
