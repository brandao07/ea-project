<template>
  <div class="action card">
    <img v-if="useImage" :src="computedImageSrc" class="card-img-top" :alt="imageAlt">
    <div class="card-body">
      <h5 v-if="title" class="card-title">{{ title }}</h5>
      <p class="card-text"><slot></slot></p>
      <p class="card-text"><small class="text-muted">Last updated {{ timeSince(lastUpdated) }}</small></p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Card",
  props: {
    useImage: {
      type: Boolean,
      default: true
    },
    title: {
      type: String,
      default: ""
    },
    imageSrc: {
      type: String,
      default: "../assets/default_images/kazuend-cCthPLHmrzI-unsplash"
    },
    imageAlt: {
      type: String,
      default: ""
    },
    lastUpdated: {
      type: String,
      required: true
    }
  },
  computed: {
    computedImageSrc() {
      return this.imageSrc || require('../assets/default_images/kazuend-cCthPLHmrzI-unsplash.jpg');
    }
  },
  methods: {
    timeSince(date) {
      const now = new Date();
      const updatedDate = new Date(date);
      const seconds = Math.floor((now - updatedDate) / 1000);
      let interval = Math.floor(seconds / 3600);

      if (interval >= 1) {
        return `${interval} hour${interval > 1 ? 's' : ''} ago`;
      }
      interval = Math.floor(seconds / 60);
      if (interval >= 1) {
        return `${interval} minute${interval > 1 ? 's' : ''} ago`;
      }
      return `${Math.floor(seconds)} second${seconds > 1 ? 's' : ''} ago`;
    }
  }
};
</script>

<style scoped>
.card {
  border-radius: 8px;
  background-color: #fff;
  box-shadow: 0 0 1em var(--color-black-rgba);
  border: none;
}

.card-img-top {
  width: 100%;
  border-top-left-radius: 8px;
  border-top-right-radius: 8px;
}

.card-body {
  padding: 1.25rem;
}

.card-title {
  margin-bottom: 0.75rem;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1; /* Number of lines for the title */
  overflow: hidden;
  text-overflow: ellipsis;
}

.card-text {
  margin-bottom: 0.75rem;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 5; /* Number of lines for the body */
  overflow: hidden;
  text-overflow: ellipsis;
}

.card-text small {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1; /* Number of lines for the date */
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
