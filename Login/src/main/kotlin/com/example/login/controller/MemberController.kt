package com.example.login.controller

import com.example.login.dto.MemberRequest
import com.example.login.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class MemberController (
    private val memberService: MemberService
    ){

    @PostMapping("/login")
    fun login(
        @RequestBody memberRequest: MemberRequest
    ): ResponseEntity<Any> {
        return memberService.login(memberRequest.email, memberRequest.password)
    }

    @PostMapping("/signup")
    fun join(
        @RequestBody memberRequest: MemberRequest
    ): ResponseEntity<Any> {
        return memberService.join(memberRequest.email, memberRequest.password)
    }
}
