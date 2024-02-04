;;; Sierra Script 1.0 - (do not remove this comment)
(script# 23)
(include sci.sh)
(use Main)
(use PolyPath)
(use Obj)


(class ExitFeature of Obj
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		cursor 999
		lastCursor -1
		exitDir 0
		noun 0
	)
	
	(method (init)
		(gLb2Exits add: self)
		(= cursor ((Cursor new:) view: cursor))
	)
	
	(method (doit)
		(cond 
			((self onMe: gX (- gY 10))
				(if (== lastCursor -1)
					(= lastCursor gCursorNumber)
					(gGame setCursor: cursor)
				)
			)
			((!= lastCursor -1)
				(if (== gCursorNumber cursor)
					(gGame setCursor: ((gIconBar walkIconItem?) cursor?))
				)
				(= lastCursor -1)
			)
		)
	)
	
	(method (dispose &tmp theCursor)
		(if (IsObject cursor)
			(= cursor ((= theCursor cursor) view?))
			(theCursor dispose:)
		)
		(gLb2Exits delete: self)
	)
	
	(method (onMe param1 param2)
		(return
			(if
				(and
					(<= nsLeft param1)
					(<= param1 nsRight)
					(<= nsTop param2)
				)
				(<= param2 nsBottom)
			else
				0
			)
		)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((not (gUser input?)))
			((not (self onMe: gX (- gY 10))))
			(
				(or
					(and
						(== (pEvent type?) evKEYBOARD)
						(!= (pEvent message?) KEY_RETURN)
					)
					(and
						(== (pEvent type?) evMOUSEBUTTON)
						(pEvent modifiers?)
					)
					(not (proc999_5 (pEvent type?) 1 4))
				)
				(= lastCursor -1)
			)
			((== gCursorNumber ((gIconBar at: 1) cursor?)) (pEvent claimed: 1) (gLb2Messager say: noun 1))
			((!= gCursorNumber cursor))
			(else
				(pEvent claimed: 1)
				(switch exitDir
					(1
						(gEgo setMotion: PolyPath gX 0)
					)
					(3
						(gEgo setMotion: PolyPath gX 190)
					)
					(2
						(gEgo setMotion: PolyPath 320 (- gY 10))
					)
					(4
						(gEgo setMotion: PolyPath 0 (- gY 10))
					)
				)
			)
		)
	)
)
