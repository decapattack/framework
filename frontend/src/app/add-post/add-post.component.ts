import { Component, OnInit } from '@angular/core';
import { HttpClientService, Post, User } from '../service/http-client.service';
import { HttpClient, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  user: User;
  lista: any[];
  post: Post = new Post('', null, '', '', null);
  isDataAvailable = false;
  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;

  constructor(private httpClientService: HttpClientService,
              private httpClient: HttpClient
    ) { }

  ngOnInit() {
    this.isDataAvailable = true;
  }

  createPost(): void {
    this.post.user = '2';
    this.httpClientService.createPost(this.post)
        .subscribe( data => {
          alert('User created successfully.');
        });
  }

  public onFileChanged(event) {
    this.selectedFile = event.target.files[0];
  }

  onUpload() {
    console.log(this.selectedFile);
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
    this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          this.message = 'Image uploaded successfully';
        } else {
          this.message = 'Image not uploaded successfully';
        }
      }
    );
  }

  getImage() {
    this.httpClient.get('http://localhost:8080/image/get/' + this.imageName)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.picByte;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        }
    );
  }
}
