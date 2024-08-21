import axios from "axios";
import type { AxiosInstance } from "axios"; // 仅导入类型

export interface ServerCommonResponse<T> {
    code: number;
    msg: string;
    data: T;
}

class HTTPClient {
    private baseURL: string;
    private instance: AxiosInstance;

    constructor(url?: string) {
        this.baseURL = url;
        this.instance = axios.create({
            baseURL: this.baseURL
            // 你可以在这里添加更多配置，比如 headers，timeout 等
        });
    }

    async get<T>(url: string, params?: any): Promise<ServerCommonResponse<T>> {
        const resp = await this.instance.get(url, { params });
        return resp.data as ServerCommonResponse<T>;
    }

    // 你也可以添加其他 HTTP 方法，比如 post、put、delete 等
    async post<T>(url: string, data: any): Promise<ServerCommonResponse<T>> {
        const resp = await this.instance.post(url, data);
        return resp.data as ServerCommonResponse<T>;
    }
}

export default new HTTPClient("http://127.0.0.1:8080");
