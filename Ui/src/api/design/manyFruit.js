import request from '@/utils/request'

// 查询钢制菠萝列表
export function listManyFruit(query) {
  return request({
    url: '/design/manyFruit/list',
    method: 'get',
    params: query
  })
}

// 查询钢制菠萝详细
export function getManyFruit(frid) {
  return request({
    url: '/design/manyFruit/' + frid,
    method: 'get'
  })
}

// 新增钢制菠萝
export function addManyFruit(data) {
  return request({
    url: '/design/manyFruit',
    method: 'post',
    data: data
  })
}

// 修改钢制菠萝
export function updateManyFruit(data) {
  return request({
    url: '/design/manyFruit',
    method: 'put',
    data: data
  })
}

// 删除钢制菠萝
export function delManyFruit(frid) {
  return request({
    url: '/design/manyFruit/' + frid,
    method: 'delete'
  })
}
