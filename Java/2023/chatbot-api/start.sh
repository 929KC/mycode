docker run -e PARAMS=" --chatbot-api.groupId=15552882441842 --chatbot-api.openAiKey=Bearer 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 --chatbot-api.cookie=abtest_env=product; zsxq_access_token=C2EFBA97-936C-8F29-7D99-AC6A50032BCC_58FC854B6E6F6E8E; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22581228121218214%22%2C%22first_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fd16rg8unadx.feishu.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjODYwODYzZjMzYzYtMGVmOTBjMDI4NzQ0ZTU4LTI2MDAxOTUxLTEzMjcxMDQtMThjODYwODYzZjRhNSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4MTIyODEyMTIxODIxNCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22581228121218214%22%7D%2C%22%24device_id%22%3A%2218c860863f33c6-0ef90c028744e58-26001951-1327104-18c860863f4a5%22%7D; zsxqsessionid=ddf4442052a8047f0647c4a795485b2c" -p 8090:8090 --name chatbot-api -d chatbot-api/chatbot-api:1.0
