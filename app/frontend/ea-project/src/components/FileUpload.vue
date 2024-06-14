<template>
  <div class="file-upload">
    <div class="file-container">
      <label id="add-img-label" for="add-single-file">
        <div v-if="!fileContent">+</div>
        <div v-else-if="isImage" class="image-preview">
          <img :src="fileContent" alt="Selected Image">
        </div>
        <div v-else-if="isText" class="text-preview">
          <pre>{{ fileText }}</pre>
        </div>
        <div v-else class="generic-preview">
          <p>{{ selectedFile.name }}</p>
        </div>
      </label>
      <input type="file" id="add-single-file" @change="onFileChange" :accept="accept" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'file-upload',
  props: {
    accept: {
      type: String,
      default: "*/*"
    }
  },
  data() {
    return {
      selectedFile: null,
      fileContent: null,
      fileText: null,
      isImage: false,
      isText: false,
    };
  },
  methods: {
    onFileChange(event) {
      const file = event.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => {
          this.selectedFile = file;
          this.fileContent = reader.result;
          this.isImage = file.type.startsWith('image/');
          this.isText = file.type.startsWith('text/');

          if (this.isText) {
            this.readTextFile(file);
          }

          this.$emit('file-content', {
            base64: reader.result.split(',')[1], // Extract Base64 part
            name: file.name,
            type: file.type
          });
        };
        reader.onerror = error => {
          console.error('Error reading file:', error);
        };
      }
    },
    readTextFile(file) {
      const reader = new FileReader();
      reader.readAsText(file);
      reader.onload = () => {
        this.fileText = reader.result;
      };
      reader.onerror = error => {
        console.error('Error reading text file:', error);
      };
    }
  }
};
</script>

<style scoped>
.file-container {
  display: flex;
  flex-wrap: wrap;
  width: min-content;
}

.file-container label {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 150%;
  cursor: pointer;
  width: 100px;
  height: 100px;
  border: solid 1px black;
  border-radius: 5px;
  object-fit: cover;
  overflow: hidden;
}

input {
  opacity: 0;
  height: 0;
}

.image-preview img {
  max-width: 100%;
  max-height: 100%;
}

.text-preview pre {
  white-space: pre-wrap;
  word-wrap: break-word;
  max-width: 100px;
  max-height: 100px;
  overflow: auto;
  background: #f4f4f4;
  padding: 5px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.generic-preview p {
  margin: 0;
  font-size: 12px;
  text-align: center;
}
</style>
