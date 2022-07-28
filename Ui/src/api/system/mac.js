import request from '@/utils/request'

// 查询用户登录网卡地址列表
export function listMac(query) {
  return request({
    url: '/system/mac/list',
    method: 'get',
    params: query
  })
}

// 查询用户登录网卡地址详细
export function getMac(userId) {
  return request({
    url: '/system/mac/' + userId,
    method: 'get'
  })
}

// 新增用户登录网卡地址
export function addMac(data) {
  return request({
    url: '/system/mac',
    method: 'post',
    data: data
  })
}

// 修改用户登录网卡地址
export function updateMac(data) {
  return request({
    url: '/system/mac',
    method: 'put',
    data: data
  })
}

// 删除用户登录网卡地址
export function delMac(userId) {
  return request({
    url: '/system/mac/' + userId,
    method: 'delete'
  })
}
