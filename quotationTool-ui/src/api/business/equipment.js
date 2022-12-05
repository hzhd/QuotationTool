import request from '@/utils/request'

// 查询租赁设备列表
export function listEquipment(query) {
  return request({
    url: '/business/equipment/list',
    method: 'get',
    params: query
  })
}

// 查询租赁设备详细
export function getEquipment(equipmentId) {
  return request({
    url: '/business/equipment/' + equipmentId,
    method: 'get'
  })
}

// 新增租赁设备
export function addEquipment(data) {
  return request({
    url: '/business/equipment',
    method: 'post',
    data: data
  })
}

// 修改租赁设备
export function updateEquipment(data) {
  return request({
    url: '/business/equipment',
    method: 'put',
    data: data
  })
}

// 删除租赁设备
export function delEquipment(equipmentId) {
  return request({
    url: '/business/equipment/' + equipmentId,
    method: 'delete'
  })
}
