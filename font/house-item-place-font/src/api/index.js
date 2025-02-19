import axios from 'axios'

const api = axios.create({
    baseURL: 'http://your-api-domain.com/api',
    timeout: 5000
})

// 请求拦截器
api.interceptors.request.use(config => {
    config.headers.Authorization = localStorage.getItem('token')
    return config
})

export default {
    // 物品相关接口
    getItems() {
        return api.get('/items')
    },
    searchItems(keyword) {
        return api.get(`/search?keyword=${keyword}`)
    },
    // 房间相关接口
    getRooms() {
        return api.get('/rooms')
    },
    // 其他接口...
}