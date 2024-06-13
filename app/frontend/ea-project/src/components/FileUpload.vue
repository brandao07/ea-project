<template>
  <div class="file-upload">
    <input type="file" @change="onFileChange" :accept="accept" />
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
      selectedFile: null
    };
  },
  methods: {
    onFileChange(event) {
      this.selectedFile = event.target.files[0];
      this.$emit('file-selected', this.selectedFile);
    }
  }
};
</script>

<style></style>
