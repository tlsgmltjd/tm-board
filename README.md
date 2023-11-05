## 레전드 더모먼트 게시판

---

### 멀티모듈

api
- controller

core
- service

domain
- entity
- repository


| URL   | METHOD | EXPLAIN   | request body                             | response body                                                      |
|-------|--------|-----------|------------------------------------------|--------------------------------------------------------------------|
| /     | POST   | 게시물 작성    | ```{ title: stirng, content: string }``` | 200 OK                                                             |
| /     | GET    | 게시물 조회    |                                          | ```{ id: Long, title: stirng, likes: Integer }```                  |
| /{id} | GET    | 특정 게시물 조회 |                                          | ```{ id: Long, title: stirng, content: string, likes: Integer }``` |
| /{id} | PUT    | 게시물 수정    | ```{ title: stirng, content: string }``` | ```{ id: Long }```                                                 |
| /{id} | DELETE | 게시물 삭제    |                                          | 200 OK                                                             |
| /like | POST   | 게시물 좋아요   | ```{ boardId: Long }```                  | ```{ likes: Integer }```                                           |