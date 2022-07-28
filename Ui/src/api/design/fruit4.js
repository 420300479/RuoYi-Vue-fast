import request from '@/utils/request'

// 查询混合金白果列表
export function listFruit4(query) {
  return request({
    url: '/design/fruit4/list',
    method: 'get',
    params: query
  })
}

// 查询混合金白果详细
export function getFruit4(frid) {
  return request({
    url: '/design/fruit4/' + frid,
    method: 'get'
  })
}

// 新增混合金白果
export function addFruit4(data) {
  return request({
    url: '/design/fruit4',
    method: 'post',
    data: data
  })
}

// 修改混合金白果
export function updateFruit4(data) {
  return request({
    url: '/design/fruit4',
    method: 'put',
    data: data
  })
}

// 删除混合金白果
export function delFruit4(frid) {
  return request({
    url: '/design/fruit4/' + frid,
    method: 'delete'
  })
}
