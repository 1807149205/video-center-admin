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

    async post<T>(url: string, data: any): Promise<ServerCommonResponse<T>> {
        const resp = await this.instance.post(url, data);
        return resp.data as ServerCommonResponse<T>;
    }
}

export default new HTTPClient("https://8080-1807149205-videocentera-g8bg4vt1law.ws-us115.gitpod.io");
