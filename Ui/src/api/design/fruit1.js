import request from '@/utils/request'

// 查询钢制菠萝列表
export function listFruit1(query) {
  return request({
    url: '/design/fruit1/list',
    method: 'get',
    params: query
  })
}

// 查询钢制菠萝详细
export function getFruit1(frid) {
  return request({
    url: '/design/fruit1/' + frid,
    method: 'get'
  })
}

// 新增钢制菠萝
export function addFruit1(data) {
  return request({
    url: '/design/fruit1',
    method: 'post',
    data: data
  })
}

// 修改钢制菠萝
export function updateFruit1(data) {
  return request({
    url: '/design/fruit1',
    method: 'put',
    data: data
  })
}

// 删除钢制菠萝
export function delFruit1(frid) {
  return request({
    url: '/design/fruit1/' + frid,
    method: 'delete'
  })
}
