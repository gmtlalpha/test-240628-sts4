package com.rho.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class MemberController {

//	@PostMapping("/login")
//	private ResponseEntity<Void> login(@RequestBody final MemberLoginRequest request, final HttpServletRequest httpRequest) {
//	    final String memberLoginId = memberService.login(request);
//
//	    final HttpSession session = httpRequest.getSession();
//	    session.setAttribute("memberId", memberLoginId);
//	    session.setMaxInactiveInterval(3600);
//
//	    return ResponseEntity.ok().build();
//	}
	
	
//	@Configuration
//	public class SessionConfig {
//
//		@Bean
//		public CookieSerializer cookieSerializer() {
//	            DefaultCookieSerializer serializer = new DefaultCookieSerializer();
//	            serializer.setCookieName("JSESSIONID");
//	            serializer.setCookiePath("/");
//	            serializer.setDomainNamePattern("^.+?(\\w+\\.[a-z]+)$");
//	            serializer.setUseBase64Encoding(false);
//	            return serializer;
//		}
//	}
//	
//	@Slf4j
//	@Component
//	@RequiredArgsConstructor
//	public class AuthInterceptor implements HandlerInterceptor {
//
//		private static final String SESSION_KEY = "SESSION";
//		private static final String REDIS_SESSION_KEY = ":sessions:";
//
//		@Value("${spring.session.redis.namespace}")
//		private String namespace;
//
//		private final StringRedisTemplate redisTemplate;
//
//		@Override
//		public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
//			final String sessionIdByCookie = getSessionIdByCookie(request);
//			final String decodedSessionId = new String(Base64.getDecoder().decode(sessionIdByCookie.getBytes()));
//			if (!redisTemplate.hasKey(namespace + REDIS_SESSION_KEY + decodedSessionId)) {
//				log.warn("Session Cookie exist, but Session in Storage is not exist");
//				throw new AuthException.FailAuthenticationMemberException();
//			}
//
//			return true;
//		}
//			
//			...
//	}
}
