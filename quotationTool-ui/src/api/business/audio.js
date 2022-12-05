import request from '@/utils/request'

// 查询音视频库列表
export function listAudio(query) {
  return request({
    url: '/business/audio/list',
    method: 'get',
    params: query
  })
}

// 查询音视频库详细
export function getAudio(audioId) {
  return request({
    url: '/business/audio/' + audioId,
    method: 'get'
  })
}

// 新增音视频库
export function addAudio(data) {
  return request({
    url: '/business/audio',
    method: 'post',
    data: data
  })
}

// 修改音视频库
export function updateAudio(data) {
  return request({
    url: '/business/audio',
    method: 'put',
    data: data
  })
}

// 删除音视频库
export function delAudio(audioId) {
  return request({
    url: '/business/audio/' + audioId,
    method: 'delete'
  })
}

// 查询场馆信息
export function queryStadium() {
    return request({
        url: '/business/stadiumInfo/queryStadiumList',
        method: 'get'
    })
}
