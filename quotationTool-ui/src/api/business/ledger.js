import request from '@/utils/request'

// 查询档案台账列表
export function listLedger(query) {
  return request({
    url: '/business/ledger/list',
    method: 'get',
    params: query
  })
}

// 查询档案台账详细
export function getLedger(ledgerId) {
  return request({
    url: '/business/ledger/' + ledgerId,
    method: 'get'
  })
}

// 新增档案台账
export function addLedger(data) {
  return request({
    url: '/business/ledger',
    method: 'post',
    data: data
  })
}

// 修改档案台账
export function updateLedger(data) {
  return request({
    url: '/business/ledger',
    method: 'put',
    data: data
  })
}

// 删除档案台账
export function delLedger(ledgerId) {
  return request({
    url: '/business/ledger/' + ledgerId,
    method: 'delete'
  })
}
