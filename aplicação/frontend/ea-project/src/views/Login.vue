<template>
    <div id="login">
        <div class="div-center">
            <div class="content">
                <form>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row mb-3 mt-3">
                                <h3 class="card-title">Login</h3>
                            </div>
                            <div class="form-group mb-1 justify-content-start">
                                <h6 class="h5 mb-0">Welcome back!</h6>
                                <p class="text-muted mt-2">Enter your email address and password to access admin
                                    panel.
                                </p>
                            </div>
                            <div class="form-group mb-1 justify-content-start">
                                <label for="exampleInputEmail1" class="mb-2">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1"
                                    aria-describedby="emailHelp" placeholder="Enter email" v-model="username" required>
                            </div>
                            <div class="form-group mb-1">
                                <label for="exampleInputPassword1" class="mb-2">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1"
                                    placeholder="Password" v-model="password" required>
                            </div>
                            <div class="form-group mb-1">
                                <button type="submit" class="btn btn-primary" @click="login">Submit</button>
                            </div>
                            <hr />
                            <div class="form-group mb-1">
                                <button type="button" class="btn btn-link">Signup</button>
                                <button type="button" class="btn btn-link">Reset Password</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</template>

<script>

import axios from 'axios'

export default {
    name: 'login',
    data() {
        return {
            username: '',
            password: ''
        }
    },
    methods: {
        login() {
            var json = {}
            json['email'] = this.username
            json['password'] = this.password
            axios.post("http://localhost:7000/api/Login", json)
                .then(data => {
                    localStorage.setItem('jwt-token', data.data)
                    this.$router.push('/home');
                })
                .catch(error => {
                    // Handle login errors
                    console.error('Login error:', error);
                });
        }
    }
}

</script>

<style>
.div-center {
    width: 400px;
    height: 400px;
    background-color: #fcfcfc;
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    margin: auto;
    max-width: 100%;
    max-height: 100%;
    overflow: auto;
    padding: 1em 2em;
    border: 1px solid #ccc;
    border-radius: 15px;
    display: table;
}

.content {
    display: table-cell;
    vertical-align: middle;
}

.form-group {
    padding: 10px 5px;
    display: block;
    text-align: justify;
}
</style>