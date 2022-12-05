import request from '@/utils/request'

// 查询团队管理列表
export function listTeam(data) {
    return request({
        url: '/team/team/list',
        method: 'post',
        data: data
    })
}

// 查询团队管理详细
export function getTeam(id) {
    return request({
        url: '/team/team/' + id,
        method: 'get'
    })
}

// 新增团队管理
export function addTeam(data) {
    return request({
        url: '/team/team',
        method: 'post',
        data: data
    })
}

// 修改团队管理
export function updateTeam(data) {
    return request({
        url: '/team/team',
        method: 'put',
        data: data
    })
}

// 删除团队管理
export function delTeam(id) {
    return request({
        url: '/team/team/' + id,
        method: 'delete'
    })
}