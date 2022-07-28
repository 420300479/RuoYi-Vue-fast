import request from '@/utils/request'

// 查询铸铁西瓜列表
export function listFruit2(query) {
  return request({
    url: '/design/fruit2/list',
    method: 'get',
    params: query
  })
}

// 查询铸铁西瓜详细
export function getFruit2(frid) {
  return request({
    url: '/design/fruit2/' + frid,
    method: 'get'
  })
}

// 新增铸铁西瓜
export function addFruit2(data) {
  return request({
    url: '/design/fruit2',
    method: 'post',
    data: data
  })
}

// 修改铸铁西瓜
export function updateFruit2(data) {
  return request({
    url: '/design/fruit2',
    method: 'put',
    data: data
  })
}

// 删除铸铁西瓜
export function delFruit2(frid) {
  return request({
    url: '/design/fruit2/' + frid,
    method: 'delete'
  })
}
