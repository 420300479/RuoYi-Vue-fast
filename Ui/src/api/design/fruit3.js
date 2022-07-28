import request from '@/utils/request'

// 查询铝合金芒果列表
export function listFruit3(query) {
  return request({
    url: '/design/fruit3/list',
    method: 'get',
    params: query
  })
}

// 查询铝合金芒果详细
export function getFruit3(frid) {
  return request({
    url: '/design/fruit3/' + frid,
    method: 'get'
  })
}

// 新增铝合金芒果
export function addFruit3(data) {
  return request({
    url: '/design/fruit3',
    method: 'post',
    data: data
  })
}

// 修改铝合金芒果
export function updateFruit3(data) {
  return request({
    url: '/design/fruit3',
    method: 'put',
    data: data
  })
}

// 删除铝合金芒果
export function delFruit3(frid) {
  return request({
    url: '/design/fruit3/' + frid,
    method: 'delete'
  })
}
