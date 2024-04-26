import { createMemoryHistory, createRouter } from "vue-router";

const router = new createRouter({
  history: createMemoryHistory(),
  routes: [
    {
      path: "/",
      name: "index",
      meta: { requiresAuth: true }
    },
    {
      path: "/home",
      name: "home",
      component: () => import('@/views/Home.vue'),
      meta: { requiresAuth: true }
    },
    {
      path: "/login",
      name: 'login',
      component: () => import('@/views/Login.vue'),
    }
  ],
});

// Navigation guard to check for authentication
router.beforeEach((to, from, next) => {
  // Check if the route requires authentication
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    // Check if token exists in localStorage
    const token = localStorage.getItem("jwt-token");
    if (!token) {
      // Token does not exist, redirect to login page
      next("/login");
    } else {
      // Token exists, continue to the requested route
      next();
    }
  } else {
    // If the route doesn't require authentication, continue normally
    next();
  }
});

export default router;
