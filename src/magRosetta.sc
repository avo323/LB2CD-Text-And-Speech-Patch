;;; Sierra Script 1.0 - (do not remove this comment)
(script# 456)
(include sci.sh)
(use Main)
(use CueObj)
(use Game)

(public
	magRosetta 0
)

(instance magRosetta of Rm
	(properties
		picture 780
	)
	
	(method (init)
		(if (gTimers contains: (ScriptID 90 15))
			((ScriptID 90 15) client: self)
		)
		(self setRegions: 90)
		(super init:)
		(bigRosetta init:)
	)
	
	(method (cue)
		((ScriptID 90 15) setReal: self 10 0 0 global125)
	)
	
	(method (newRoom)
		(if (gTimers contains: (ScriptID 90 15))
			(= timer 0)
			((ScriptID 90 15) client: (ScriptID 90 15))
		)
		(gGameMusic2 fade: 127 20 20 0)
		(super newRoom: &rest)
	)
)

(instance bigRosetta of Feature
	(properties
		y 190
		nsTop 50
		nsLeft 50
		nsBottom 145
		nsRight 210
	)
	
	(method (init)
		(gLb2KDH addToFront: self)
		(gLb2MDH addToFront: self)
		(gGameMusic2 fade: 80 20 20 0)
		(gIconBar disable: 7)
		(super init: &rest)
		(gIconBar curIcon: (gIconBar at: 1) disable:)
		(if (== gGNumber 454)
			(DrawPic 455 dpOPEN_NO_TRANSITION)
		else
			(DrawPic 521 dpOPEN_NO_TRANSITION)
		)
		(gGame setCursor: 996)
		(if (== gGNumber 454)
			(SetCursor 2 79 55 239 144 86 0 0 456 53)
		else
			(SetCursor 2 79 55 239 144 86 0 0 527 53)
		)
		(Animate (gOldCast elements?) 0)
	)
	
	(method (dispose)
		(gLb2KDH delete: self)
		(gLb2MDH delete: self)
		(super dispose: &rest)
		(gIconBar enable: 7)
		(global2 newRoom: gGNumber)
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(== (pEvent type?) evMOUSEBUTTON)
				(== (pEvent type?) evKEYBOARD)
			)
			(SetCursor -1)
			(gGame setCursor: ((gIconBar curIcon?) cursor?) 1)
			(pEvent claimed: 1)
			(self dispose:)
			(gIconBar enable:)
		)
	)
)
