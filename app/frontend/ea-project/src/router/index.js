import { createMemoryHistory, createRouter } from "vue-router";

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import('@/views/Home.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: "/administration",
    name: "administration",
    component: () => import('@/views/Administration.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: "/login",
    name: 'login',
    component: () => import('@/views/Login.vue'),
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('@/views/Register.vue'),
  }
];

const router = createRouter({
  history: createMemoryHistory(),
  routes,
});

// Navigation guard to check for authentication
router.beforeEach((to, from, next) => {
  console.log("Navigation guard triggered");
  // Check if the route requires authentication
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    console.log("Route requires authentication");
    // Check if token exists in localStorage
    const token = localStorage.getItem("jwt-token");
    console.log("Token:", token);
    if (!token) {
      console.log("Token does not exist, redirecting to login");
      // Token does not exist, redirect to login page
      next("/login");
    } else {
      console.log("Token exists, continuing to the requested route");
      // Token exists, continue to the requested route
      next();
    }
  } else {
    console.log("Route does not require authentication, continuing");
    // If the route doesn't require authentication, continue normally
    next();
  }
});

export default router;
