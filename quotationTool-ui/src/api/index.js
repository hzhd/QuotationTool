import request from '@/utils/request'

// 柱状图数据
export function subscribeNames() {
    return request({
        url: '/business/subscribe/names',
        method: 'get',
        data: ''
    })
}

// 产品影响力
export function infoNames() {
    return request({
        url: '/business/info/names',
        method: 'get',
        data: ''
    })
}

// 活动预告
export function activityNums() {
    return request({
        url: '/business/activity/nums',
        method: 'get',
        data: ''
    })
}