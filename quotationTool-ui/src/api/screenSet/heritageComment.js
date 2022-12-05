import request from '@/utils/request'

// 查询非遗评论列表
export function listHeritageComment(query) {
  return request({
    url: '/screenSet/heritageComment/list',
    method: 'get',
    params: query
  })
}

// 查询项目列表
export function getProject() {
  return request({
    url: '/screenSet/heritageComment/getProject',
    method: 'get'
  })
}

// 查询非遗评论详细
export function getHeritageComment(id) {
  return request({
    url: '/screenSet/heritageComment/' + id,
    method: 'get'
  })
}

// 新增非遗评论
export function addHeritageComment(data) {
  return request({
    url: '/screenSet/heritageComment',
    method: 'post',
    data: data
  })
}

// 修改非遗评论
export function updateHeritageComment(data) {
  return request({
    url: '/screenSet/heritageComment',
    method: 'put',
    data: data
  })
}

// 删除非遗评论
export function delHeritageComment(id) {
  return request({
    url: '/screenSet/heritageComment/' + id,
    method: 'delete'
  })
}
