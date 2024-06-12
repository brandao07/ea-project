<template>
  <div class="grid-container" :size="size" :style="gridStyle.gridTemplateColumns">
    <div v-for="(item, index) in items" :key="index" class="grid-item">
      <slot :item="item"></slot>
      <div class="grid-footer">
        {{ item.date }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "GridLayout",
  props: {
    items: {
      type: Array,
      required: true
    },
    size: {
      type: Number,
      default: 300
    }
  },
  computed: {
    gridStyle() {
      return {
        gridTemplateColumns: `grid-template-columns: repeat(auto-fill, minmax(${this.size}px, 1fr))`
      };
    }
  }
};
</script>

<style scoped>
.grid-container {
  display: grid;
  gap: 20px;
  padding: 20px;
}

.grid-item {
  display: flex;
  justify-content: center;
  min-width: 200px;
}
</style>