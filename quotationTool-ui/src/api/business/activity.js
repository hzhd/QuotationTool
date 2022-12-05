import request from '@/utils/request'

// 查询活动库数据列表
export function listActivity(query) {
    return request({
        url: '/business/activity/list',
        method: 'get',
        params: query
    })
}

// 查询活动库数据详细
export function getActivity(activityId) {
    return request({
        url: '/business/activity/' + activityId,
        method: 'get'
    })
}

// 新增活动库数据
export function addActivity(data) {
    return request({
        url: '/business/activity',
        method: 'post',
        data: data
    })
}

// 修改活动库数据
export function updateActivity(data) {
    return request({
        url: '/business/activity',
        method: 'put',
        data: data
    })
}

// 删除活动库数据
export function delActivity(activityId) {
    return request({
        url: '/business/activity/' + activityId,
        method: 'delete'
    })
}