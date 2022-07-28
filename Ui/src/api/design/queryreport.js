import request from '@/utils/request'

// 查询计算列表
export function listfruit1(query) {
  return request({
    url: '/design/queryreport/list',
    method: 'get',
    params: query
  })
}