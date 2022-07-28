import request from '@/utils/request'

// 查询计算列表
export function listQzsjjs(query) {
  return request({
    url: '/design/report/list',
    method: 'get',
    params: query
  })
}

// 查询计算详细
export function getQzsjjs(prId) {
  return request({
    url: '/design/report/' + prId,
    method: 'get'
  })
}

