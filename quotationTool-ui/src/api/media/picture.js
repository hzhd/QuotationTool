import request from '@/utils/request'

// 查询图片基本信息库列表
export function listPicture(query) {
    return request({
        url: '/media/picture/list',
        method: 'get',
        params: query
    })
}

// 查询图片基本信息库详细
export function getPicture(id) {
    return request({
        url: '/media/picture/' + id,
        method: 'get'
    })
}

// 新增图片基本信息库
export function addPicture(data) {
    return request({
        url: '/media/picture',
        method: 'post',
        data: data
    })
}

// 修改图片基本信息库
export function updatePicture(data) {
    return request({
        url: '/media/picture',
        method: 'put',
        data: data
    })
}

// 删除图片基本信息库
export function delPicture(id) {
    return request({
        url: '/media/picture/' + id,
        method: 'delete'
    })
}


// 查询场馆信息
export function queryStadium(data) {
    return request({
        url: '/media/picture/queryStadium',
        method: 'get'
    })
}

// 查询图片类型
export function queryPicType(data) {
    return request({
        url: '/system/dict/data/type/pic_type',
        method: 'get'
    })
}