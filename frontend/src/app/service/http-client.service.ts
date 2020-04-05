import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class User{
  constructor(
    public id: string,
    public login: string,
    public password: string
  ){}
}

export class Post {
  constructor(
    public id: string,
    public user: string,
    public titulo: string,
    public corpo: string,
    public comentarios: any[]
  ){}
}

export class Comment{
  constructor(
    public id: string,
    public comentario: string,
    public user: string,
    public post: string
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient: HttpClient) { }

  getUsers() {
    return this.httpClient.get<User[]>('http://localhost:8080/users/all');
  }

  public deleteUser(user) {
    return this.httpClient.delete<User>('http://localhost:8080/users/' + user.id);
  }

  public createUser(user) {
    return this.httpClient.post<User>('http://localhost:8080/users/', user);
  }

  getPosts() {
    return this.httpClient.get<Post[]>('http://localhost:8080/posts/all');
  }

  public getPost(id: string) {
    return this.httpClient.get<Post>('http://localhost:8080/posts/postComComentarios/' + id);
  }

  public deletePost(post) {
    return this.httpClient.delete<Post>('http://localhost:8080/posts/' + post.id);
  }

  public createPost(post) {
    return this.httpClient.post<Post>('http://localhost:8080/posts/', post);
  }


}
